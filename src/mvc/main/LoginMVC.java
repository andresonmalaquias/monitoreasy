package mvc.main;

import controller.main.LoginController;
import view.main.LoginView;

public class LoginMVC {
    public static void main(String args[]){
        new LoginController(new LoginView());
    }
}