package vanar.lab8gui;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GUIController {
    private FileChooser fileSave; // FileChooser for saving CSV and graph files
    private File csvFile; // File object for the CSV file
    private File graphFile; // File object for the graph image file

    @FXML
    private Button createGraph; // Button for creating the graph

    @FXML
    private Button run; // Button for running the test

    /**
     * Handles the action for saving the test results to a CSV file.
     */
    @FXML
    private void saveRunAction(ActionEvent event) throws IOException {
        // Initialize the FileChooser for saving the CSV file
        fileSave = new FileChooser();
        fileSave.setInitialFileName("SortingSpeed.csv"); // Default file name
        fileSave.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files (*.csv)", "*.csv"));
        Stage stage = (Stage) run.getScene().getWindow();
        csvFile = fileSave.showSaveDialog(stage); // Show save dialog

        if (csvFile != null) {
            // Ensure the file has a .csv extension
            if (!csvFile.getName().toLowerCase().endsWith(".csv")) {
                csvFile = new File(csvFile.getAbsolutePath() + ".csv");
            }
            try {
                csvFile.createNewFile(); // Create the file
                run.getScene().setCursor(Cursor.WAIT); // Set cursor to WAIT
                RunTest.startTest(csvFile); // Run the test and save results to the file
                System.out.println("Tests Run\nFile Saved");
                run.getScene().setCursor(Cursor.DEFAULT); // Reset cursor to DEFAULT
                Alert a = new Alert(AlertType.CONFIRMATION, "Tests Run\nFile Successfully Saved");
                a.show(); // Show confirmation alert
                createGraph.setDisable(false); // Enable the "Create Graph" button
            } catch (IOException e) {
                System.out.println("An error occurred."); // Log error
            }
        }
    }

    /**
     * Handles the action for saving the graph as a PNG image.
     */
    @FXML
    private void saveGraph(ActionEvent event) throws IOException {
        run.getScene().setCursor(Cursor.WAIT);

        if (csvFile == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No CSV file found. Please run the test first.");
            alert.show();
            run.getScene().setCursor(Cursor.DEFAULT);
            return;
        }

        List<String[]> data = CSVRead.readCSV(csvFile);
        if (data == null || data.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No data found in the CSV file.");
            alert.show();
            run.getScene().setCursor(Cursor.DEFAULT);
            return;
        }

        String[] headers = {"Data Size", "Selection Sort", "Insertion Sort", "Merge Sort"};

        // Canvas setup with padding
        Canvas canvas = new Canvas(900, 650);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double leftPad = 80;
        double rightPad = 50;
        double topPad = 60;
        double bottomPad = 80;
        double graphWidth = canvas.getWidth() - leftPad - rightPad;
        double graphHeight = canvas.getHeight() - topPad - bottomPad;

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Title
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gc.fillText("Sorting Algorithm Performance", canvas.getWidth() / 2 - 180, 35);

        // Axes
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeLine(leftPad, canvas.getHeight() - bottomPad, canvas.getWidth() - rightPad, canvas.getHeight() - bottomPad); // X-axis
        gc.strokeLine(leftPad, canvas.getHeight() - bottomPad, leftPad, topPad); // Y-axis

        // Axis labels
        gc.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        gc.fillText("Data Size", canvas.getWidth() / 2 - 30, canvas.getHeight() - 30);
        gc.save();
        gc.translate(25, canvas.getHeight() / 2 + 40);
        gc.rotate(-90);
        gc.fillText("Time (ms, log scale)", 0, 0);
        gc.restore();

        // Compute Y scale
        double logMax = 0;
        for (String[] row : data) {
            for (int col = 1; col <= 3; col++) {
                try {
                    double val = Double.parseDouble(row[col].trim());
                    logMax = Math.max(logMax, Math.log10(val + 1));
                } catch (Exception ignored) {}
            }
        }
        double yScale = graphHeight / logMax;
        double xScale = graphWidth / (data.size() - 1);

        // Y-axis major ticks: powers of 10 (10^0 to 10^ceil(logMax))
        gc.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        for (int i = 0; i <= (int) Math.ceil(logMax); i++) {
            int y = (int) (canvas.getHeight() - bottomPad - (i * yScale));
            String label = String.format("%.0f", Math.pow(10, i)); // e.g., "10", "100", "1000"
            gc.setStroke(Color.LIGHTGRAY);
            gc.strokeLine(leftPad, y, canvas.getWidth() - rightPad, y);
            gc.setFill(Color.BLACK);
            gc.fillText(label, leftPad - 50, y + 5); // Extra space for alignment
        } 
        // X-axis grid lines and ticks
        for (int i = 0; i < data.size(); i++) {
            String size = data.get(i)[0].trim();
            int x = (int) (leftPad + (i * xScale));
            if (size.equals("10000") || size.equals("100000") || i % 2 == 0) {
                gc.setStroke(Color.LIGHTGRAY);
                gc.strokeLine(x, topPad, x, canvas.getHeight() - bottomPad);
                gc.setStroke(Color.BLACK);
                gc.strokeText(size, x - 15, canvas.getHeight() - bottomPad + 20);
            }
        }
        // Move legend to cleaner position
        double legendX = leftPad + 10; // or center it with canvas.getWidth()/2 - X
        double legendY = topPad + 10;

        gc.setFill(Color.WHITE);
        gc.fillRect(legendX - 10, legendY - 10, 170, 80);

        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
        String[] labels = {headers[1], headers[2], headers[3]};
        for (int i = 0; i < 3; i++) {
            gc.setFill(colors[i]);
            gc.fillRect(legendX, legendY + i * 20, 10, 10);
            gc.setFill(Color.BLACK);
            gc.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
            gc.fillText(labels[i], legendX + 15, legendY + 10 + i * 20);
        }
        // Trend lines
        for (int col = 1; col <= 3; col++) {
            double[] xVals = new double[data.size()];
            double[] yVals = new double[data.size()];

            for (int i = 0; i < data.size(); i++) {
                xVals[i] = Double.parseDouble(data.get(i)[0].trim());
                yVals[i] = Math.log10(Double.parseDouble(data.get(i)[col].trim()) + 1);
            }

            double[] coeffs = polynomialFit(xVals, yVals, 2);
            gc.setStroke(colors[col - 1]);
            gc.setLineWidth(2);

            for (int i = 1; i < xVals.length; i++) {
                double x1val = xVals[i - 1];
                double x2val = xVals[i];
                double y1val = coeffs[0] + coeffs[1] * x1val + coeffs[2] * x1val * x1val;
                double y2val = coeffs[0] + coeffs[1] * x2val + coeffs[2] * x2val * x2val;

                int x1 = (int) (leftPad + (i - 1) * xScale);
                int y1 = (int) (canvas.getHeight() - bottomPad - (y1val * yScale));
                int x2 = (int) (leftPad + i * xScale);
                int y2 = (int) (canvas.getHeight() - bottomPad - (y2val * yScale));

                gc.strokeLine(x1, y1, x2, y2);
            }
        }

        run.getScene().setCursor(Cursor.DEFAULT);

        // Save PNG
        WritableImage image = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
        canvas.snapshot(null, image);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("SortingGraph.png");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        graphFile = fileChooser.showSaveDialog((Stage) run.getScene().getWindow());

        if (graphFile != null) {
            try {
                if (!graphFile.getName().toLowerCase().endsWith(".png")) {
                    graphFile = new File(graphFile.getAbsolutePath() + ".png");
                }
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", graphFile);
                new Alert(Alert.AlertType.CONFIRMATION, "Graph successfully saved as PNG.").show();
            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the graph as PNG.").show();
            }
        }
    }

    private double[] polynomialFit(double[] x, double[] y, int degree) {
        int n = x.length;
        double[][] X = new double[degree + 1][degree + 2];

        for (int i = 0; i <= degree; i++) {
            for (int j = 0; j <= degree; j++) {
                for (int k = 0; k < n; k++) {
                    X[i][j] += Math.pow(x[k], i + j);
                }
            }
            for (int k = 0; k < n; k++) {
                X[i][degree + 1] += y[k] * Math.pow(x[k], i);
            }
        }

        for (int i = 0; i <= degree; i++) {
            for (int k = i + 1; k <= degree; k++) {
                double t = X[k][i] / X[i][i];
                for (int j = 0; j <= degree + 1; j++) {
                    X[k][j] -= t * X[i][j];
                }
            }
        }

        double[] a = new double[degree + 1];
        for (int i = degree; i >= 0; i--) {
            a[i] = X[i][degree + 1];
            for (int j = i + 1; j <= degree; j++) {
                a[i] -= X[i][j] * a[j];
            }
            a[i] /= X[i][i];
        }

        return a;
    }
}
