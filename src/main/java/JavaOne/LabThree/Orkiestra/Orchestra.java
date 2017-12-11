package JavaOne.LabThree.Orkiestra;

import java.util.ArrayList;

public class Orchestra implements Instrument {
    ArrayList<Instrument> instruments;
    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(ArrayList<Instrument> instruments) {
        this.instruments = instruments;
    }



    public Orchestra(){
        instruments = new ArrayList<Instrument>();
    }

    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Flute flute = new Flute();
        Trombone trombone = new Trombone();

        Orchestra orchestra = new Orchestra();
        orchestra.addInstrument(guitar);
        orchestra.addInstrument(flute);
        orchestra.addInstrument(trombone);
        orchestra.play();


    }
    public void addInstrument(Instrument instrument){
        instruments.add(instrument);
    }

    public void play() {
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }
}
