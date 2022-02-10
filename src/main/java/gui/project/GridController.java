package gui.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class GridController implements Initializable {


    @FXML
    public GridPane grid;

    RootController rootController;


    public void injectMainController(RootController rootController) {
        this.rootController = rootController;
    }

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        grid.setVgap(8);
        grid.setHgap(8);
        grid.setAlignment(Pos.CENTER);
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                Rectangle r = new Rectangle(col * 50, row * 50, 50, 50);
                r.setFill((col + row) % 2 == 0 ? Color.GRAY : Color.WHITE);
                r.setStroke(Color.GRAY);
                grid.addRow(row, r);
                r.setOnMouseClicked(this::clickGrid);
            }
        }

    }

    String getSymbol(){
        return this.rootController.getSymbol();
    }


    @FXML
    private void clickGrid(MouseEvent event) {

        Node source = (Node)event.getSource() ;
        Integer colIndex = grid.getColumnIndex(source);
        Integer rowIndex = grid.getRowIndex(source);
        ImageView im = new ImageView(getSymbol());
        im.setFitHeight(50);
        im.setFitWidth(50);
        grid.add(im, colIndex, rowIndex);

    }





}

