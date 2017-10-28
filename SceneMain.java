import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SceneMain {
    private Stage main =new Stage();
    private javafx.scene.control.Button start=new javafx.scene.control.Button("开始");
    private javafx.scene.control.Button input=new javafx.scene.control.Button("...");
    private javafx.scene.control.Button output=new javafx.scene.control.Button("...");
    private Button Exit=new Button("退出");
    private Button Back=new Button("返回首页");
    private Text inputfile;
    private Text outputpath;
    private javafx.scene.control.TextField inputField=new javafx.scene.control.TextField();
    private javafx.scene.control.TextField outputFeild=new TextField();
    SceneMain(int selection,Stage begin)throws IOException{
        output.setOnAction(event -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int flag=fileChooser.showOpenDialog(fileChooser);
            if (flag==JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                outputFeild.setText(file.getAbsolutePath());
            }
        });
        Exit.setOnAction(event -> {
            main.close();
            begin.close();
        });
        Back.setOnAction(event -> {
            main.close();
            begin.show();
        });
        if (selection==2){
            this.inputfile=new Text("请选择要压缩的文件");
            this.outputpath=new Text("请选择输出目录");
           start.setOnAction(event -> {
               try {
                   CompressDestribute compressDestribute=new CompressDestribute(this.inputField.getText(),
                           this.outputFeild.getText());
                   if (compressDestribute.getX()==1) {
                       main.close();
                       begin.show();
                       SceneWarning sceneWarning=new SceneWarning("压缩完成");
                   }

               } catch (IOException e) {
                   e.printStackTrace();
               }
           });
            input.setOnAction(event -> {
                JFileChooser fileChooser = new JFileChooser();
                int flag=fileChooser.showOpenDialog(fileChooser);
                if (flag==JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    inputField.setText(file.getAbsolutePath());
                }
            });
        }else if (selection==1){
            this.inputfile=new Text("请选择要解压的文件");
            this.outputpath=new Text("请选择输出目录");
            start.setOnAction(event -> {
                try {
                   DeCompressDistribute compressDestribute=new DeCompressDistribute(this.inputField.getText(),
                            this.outputFeild.getText());
                   if (compressDestribute.getX()==1) {
                       main.close();
                       begin.show();
                       SceneWarning sceneWarning = new SceneWarning("解压完成");
                   }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            input.setOnAction(event -> {
                JFileChooser fileChooser = new JFileChooser();
                int flag=fileChooser.showOpenDialog(fileChooser);
                if (flag==JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    inputField.setText(file.getAbsolutePath());
                }
            });
        }else if (selection==0){
            this.inputfile=new Text("请选择要压缩的文件");
            this.outputpath=new Text("请选择输出目录");
            start.setOnAction(event -> {
                try {
                    CompressDestribute compressDestribute=new CompressDestribute(this.inputField.getText(),
                            this.outputFeild.getText());
                    if (compressDestribute.getX()==1) {
                        main.close();
                        begin.show();
                        SceneWarning sceneWarning=new SceneWarning("压缩完成");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            input.setOnAction(event -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int flag=fileChooser.showOpenDialog(fileChooser);
                if (flag==JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                   inputField.setText(file.getAbsolutePath());
                }
            });
        }
       HBox first=new HBox();
        HBox second=new HBox();
        HBox third=new HBox();
        inputField.setPrefSize(200,20);
        outputFeild.setPrefSize(200,20);
        first.getChildren().addAll(inputfile,inputField,input);
        first.setAlignment(Pos.CENTER);
        first.setSpacing(30);
        second.getChildren().addAll(outputpath,outputFeild,output);
        second.setAlignment(Pos.CENTER);
        second.setSpacing(30);
        third.getChildren().addAll(start,Exit,Back);
        third.setAlignment(Pos.CENTER);
        third.setSpacing(100);
        Exit.setPrefSize(80,30);
        start.setPrefSize(80,30);
        Back.setPrefSize(80,30);
        VBox all=new VBox();
        all.getChildren().addAll(first,second,third);
        all.setSpacing(100);
        all.setAlignment(Pos.CENTER);
        all.setPrefSize(600,400);
        Scene scene=new Scene(all,600,400);
        main.setScene(scene);
        main.setTitle("rwq压缩");
        main.show();
    }
}
