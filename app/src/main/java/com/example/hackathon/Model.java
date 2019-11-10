package com.example.hackathon;

public class Model {
    String image;
    String name;
    public Model(){}
   /* public Model(String image, String name) {
        this.name = name;
        this.image=image;
    }
*/


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
