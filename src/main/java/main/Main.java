package main;

import gui.panels.MainFrame;
import structures.Spheres;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.awt.*;
import java.io.File;

public class Main {
    private Main() {
    }

    public static void main(String[] args) {

        Spheres spheres = loadScenario();
        if (spheres == null) {
            spheres = new Spheres();
        }

        spheres.getSpheres().forEach(sphere -> {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MainFrame(sphere);
                }
            });
        });

    }

    private static Spheres loadScenario() {
        Spheres spheres;
        try {

            File file = new File("src/main/resources/scenario.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Spheres.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            spheres = (Spheres) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

        return spheres;
    }

}
