import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import games.FollowTheLeaderGame;
import games.*;

public class StartGame extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Game game = new TetrahederGame();
        Node gameView = game.getGameView();

        BorderPane borderPane = new BorderPane(gameView);
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.show();

        game.start();
    }
}
