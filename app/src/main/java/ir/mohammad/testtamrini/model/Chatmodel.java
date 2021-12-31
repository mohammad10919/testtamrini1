package ir.mohammad.testtamrini.model;

public class Chatmodel {

    String textchat;
    String imagechat;

    public Chatmodel(String textchat, String imagechat) {
        this.textchat = textchat;
        this.imagechat = imagechat;
    }

    public String getTextchat() {
        return textchat;
    }

    public void setTextchat(String textchat) {
        this.textchat = textchat;
    }

    public String getImagechat() {
        return imagechat;
    }

    public void setImagechat(String imagechat) {
        this.imagechat = imagechat;
    }
}
