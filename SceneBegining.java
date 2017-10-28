import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.awt.*;
import java.io.IOException;

public class SceneBegining extends Application {
    private Stage start =new Stage();
    public void start(Stage stage){
        Pane startScene=new GridPane();
        HBox Slelection=new HBox();
        VBox all=new VBox();
        javafx.scene.text.Text Welcome = new javafx.scene.text.Text("您好，欢迎使用本压缩软件，" +
                "请点击按钮选择您要执行的操作" );
        Button Compress=new Button("压缩文件夹");
        Compress.setOnAction(event -> {
            try {
                start.hide();
                SceneMain sceneMain=new SceneMain(0,start);
            }catch (IOException e){

            }

        });
        Button Compress1=new Button("压缩单个文件");
        Compress1.setOnAction(event -> {
            try {
                start.hide();
                SceneMain sceneMain=new SceneMain(2,start);
            }catch (IOException e){

            }
        });
        Button DeCompress=new Button("解压");
        DeCompress.setOnAction(event -> {
            try {
                start.hide();
                SceneMain sceneMain=new SceneMain(1,start);
            }catch (IOException e){

            }
        });
        Button Exit=new Button("退出");
        Exit.setOnAction(event -> {
            start.close();
        });
      Compress.setPrefSize(80,30);
      DeCompress.setPrefSize(80,30);
      Compress1.setPrefSize(80,30);
      Exit.setPrefSize(80,30);
      Welcome.setFont(Font.font("宋体", FontWeight.BOLD, FontPosture.REGULAR,20));
      Slelection.getChildren().addAll(Compress,Compress1,DeCompress,Exit);
      Slelection.setSpacing(60);
      Slelection.setAlignment(Pos.CENTER);
      Welcome.setTextAlignment(TextAlignment.CENTER);
      all.getChildren().addAll(Welcome,Slelection);
     /* all.setAlignment(Pos.BASELINE_RIGHT);*/
     all.setPrefSize(620,400);
      all.setSpacing(150);
      startScene.getChildren().add(all);
        Scene scene=new Scene(startScene,620,400);
        start.setScene(scene);
        start.setTitle("rwq压缩");
        start.show();
    }
}
