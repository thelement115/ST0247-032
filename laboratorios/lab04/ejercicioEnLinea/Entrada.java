import java.util.Arrays;

public class Entrada {
    private int conductores;
    private int duracion;
    private int tarifa;

    private int [] mañana;
    private int [] noche;

    public Entrada(int conductores, int duracion, int tarifa, int [] mañana, int[]noche){
        this.conductores = conductores;
        this.tarifa = tarifa;
        this.duracion = duracion;
        this.mañana = mañana;
        this.noche = noche;
    }

    public int HoraExtra (){
        Arrays.sort(mañana);
        Arrays.sort(noche);
        int extra =0;
        int horas = 0;
        int x = 0;
        for(int i =0; i < mañana.length;++i){
            x = mañana[i] + noche[noche.length-1-i];
            horas = x-duracion;
            extra = horas*tarifa;
        }
        return extra;
    }
}
