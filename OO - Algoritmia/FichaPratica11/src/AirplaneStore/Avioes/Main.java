package AirplaneStore.Avioes;

import AirplaneStore.Enums.Armas;
import AirplaneStore.Enums.Categoria;
import AirplaneStore.Enums.Instalacoes;

import java.util.ArrayList;

public class Main {
    static void main() {

        JatoParticular jato1 = new JatoParticular(
                101, "Gulfstream G650", 2020, 33000, 30.4, 30.4, 7.7,
                2, 12900, 956, 65000000, 18, 2900,
                Categoria.HeavyJet, Instalacoes.Cinema);

        JatoParticular jato2 = new JatoParticular(
                102, "Cessna Citation X", 2018, 16500, 22.0, 21.0, 6.0,
                2, 6000, 972, 23000000, 12, 1500,
                Categoria.LightJet, Instalacoes.Chuveiro);

        JatoParticular jato3 = new JatoParticular(
                103, "Embraer Phenom 300", 2021, 8000, 15.6, 15.9, 5.1,
                2, 3650, 839, 9500000, 7, 900,
                Categoria.MidsizeJet, Instalacoes.Escritório);


        AviaoCombate combate1 = new AviaoCombate(
                201, "F-22 Raptor", 2015,
                19700.0, 18.9, 13.6, 5.1,
                2, 2960.0, 2410.0, 150_000_000.0,
                "EUA", true, Armas.Misseis
        );

        AviaoCombate combate2 = new AviaoCombate(
                202, "Su-57 Felon", 2022,
                18000.0, 20.1, 14.1, 4.7,
                2, 3500.0, 2600.0, 50_000_000.0,
                "Rússia", false, Armas.Metralhadoras
        );

        AviaoCombate combate3 = new AviaoCombate(
                203, "Dassault Rafale", 2019,
                10600.0, 15.3, 10.8, 5.3,
                2, 3700.0, 1912.0, 74_000_000.0,
                "França", true, Armas.Bombas
        );

        Catalogo listaAvioes = new Catalogo (new ArrayList<Aviao>());

        listaAvioes.adquirirAvioes(jato3);
        listaAvioes.adquirirAvioes(jato1);
        listaAvioes.adquirirAvioes(jato2);

        listaAvioes.exibirDetalhesCatalogo();


    }
}
