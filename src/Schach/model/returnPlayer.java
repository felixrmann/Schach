package Schach.model;

/**
 * The type Return player.
 *
 * @author Felix Mann
 * @version 1.0
 * @since 2019 -November-30
 */
public class returnPlayer {

    private static WeissBauer[] weissBauerFiguren;
    private static WeissLaeufer[] weissLaeuferFiguren;
    private static WeissTurm[] weissTurmFiguren;
    private static WeissPferd[] weissPferdFiguren;
    private static WeissKoenig weissKoenigFigur;
    private static WeissDame weissDameFigur;

    private static SchwarzBauer[] schwarzBauerFiguren;
    private static SchwarzLaeufer[] schwarzLaeuferFiguren;
    private static SchwarzTurm[] schwarzTurmFiguren;
    private static SchwarzPferd[] schwarzPferdFiguren;
    private static SchwarzKoenig schwarzKoenigFigur;
    private static SchwarzDame schwarzDameFigur;

    /**
     * Instantiates a new Return player.
     *
     * @param weissBauer1     the weiss bauer 1
     * @param weissBauer2     the weiss bauer 2
     * @param weissBauer3     the weiss bauer 3
     * @param weissBauer4     the weiss bauer 4
     * @param weissBauer5     the weiss bauer 5
     * @param weissBauer6     the weiss bauer 6
     * @param weissBauer7     the weiss bauer 7
     * @param weissBauer8     the weiss bauer 8
     * @param weissKoenig     the weiss koenig
     * @param weissDame       the weiss dame
     * @param weissLaeufer1   the weiss laeufer 1
     * @param weissLaeufer2   the weiss laeufer 2
     * @param weissTurm1      the weiss turm 1
     * @param weissTurm2      the weiss turm 2
     * @param weissPferd1     the weiss pferd 1
     * @param weissPferd2     the weiss pferd 2
     * @param schwarzBauer1   the schwarz bauer 1
     * @param schwarzBauer2   the schwarz bauer 2
     * @param schwarzBauer3   the schwarz bauer 3
     * @param schwarzBauer4   the schwarz bauer 4
     * @param schwarzBauer5   the schwarz bauer 5
     * @param schwarzBauer6   the schwarz bauer 6
     * @param schwarzBauer7   the schwarz bauer 7
     * @param schwarzBauer8   the schwarz bauer 8
     * @param schwarzKoenig   the schwarz koenig
     * @param schwarzDame     the schwarz dame
     * @param schwarzLaeufer1 the schwarz laeufer 1
     * @param schwarzLaeufer2 the schwarz laeufer 2
     * @param schwarzTurm1    the schwarz turm 1
     * @param schwarzTurm2    the schwarz turm 2
     * @param schwarzPferd1   the schwarz pferd 1
     * @param schwarzPferd2   the schwarz pferd 2
     */
    public returnPlayer(WeissBauer weissBauer1, WeissBauer weissBauer2, WeissBauer weissBauer3, WeissBauer weissBauer4,
                        WeissBauer weissBauer5, WeissBauer weissBauer6, WeissBauer weissBauer7, WeissBauer weissBauer8,
                        WeissKoenig weissKoenig, WeissDame weissDame, WeissLaeufer weissLaeufer1, WeissLaeufer weissLaeufer2,
                        WeissTurm weissTurm1, WeissTurm weissTurm2, WeissPferd weissPferd1, WeissPferd weissPferd2,
                        SchwarzBauer schwarzBauer1, SchwarzBauer schwarzBauer2, SchwarzBauer schwarzBauer3, SchwarzBauer schwarzBauer4,
                        SchwarzBauer schwarzBauer5, SchwarzBauer schwarzBauer6, SchwarzBauer schwarzBauer7, SchwarzBauer schwarzBauer8,
                        SchwarzKoenig schwarzKoenig, SchwarzDame schwarzDame, SchwarzLaeufer schwarzLaeufer1, SchwarzLaeufer schwarzLaeufer2,
                        SchwarzTurm schwarzTurm1, SchwarzTurm schwarzTurm2, SchwarzPferd schwarzPferd1, SchwarzPferd schwarzPferd2)
    {
        weissBauerFiguren = new WeissBauer[]{weissBauer1,weissBauer2,weissBauer3,weissBauer4,weissBauer5,weissBauer6,weissBauer7,weissBauer8};
        weissLaeuferFiguren = new WeissLaeufer[]{weissLaeufer1, weissLaeufer2};
        weissTurmFiguren = new WeissTurm[]{weissTurm1,weissTurm2};
        weissPferdFiguren = new WeissPferd[]{weissPferd1, weissPferd2};
        weissKoenigFigur = weissKoenig;
        weissDameFigur = weissDame;

        schwarzBauerFiguren = new SchwarzBauer[]{schwarzBauer1,schwarzBauer2,schwarzBauer3,schwarzBauer4,schwarzBauer5,schwarzBauer6,schwarzBauer7,schwarzBauer8};
        schwarzLaeuferFiguren = new SchwarzLaeufer[]{schwarzLaeufer1, schwarzLaeufer2};
        schwarzTurmFiguren = new SchwarzTurm[]{schwarzTurm1,schwarzTurm2};
        schwarzPferdFiguren = new SchwarzPferd[]{schwarzPferd1, schwarzPferd2};
        schwarzKoenigFigur = schwarzKoenig;
        schwarzDameFigur = schwarzDame;
    }

    /**
     * Get weiss bauer weiss bauer.
     *
     * @param welcher the welcher
     * @return the weiss bauer
     */
    static WeissBauer getWeissBauer(int welcher){
        return weissBauerFiguren[welcher - 1];
    }

    /**
     * Get weiss leaufer weiss laeufer.
     *
     * @param welcher the welcher
     * @return the weiss laeufer
     */
    static WeissLaeufer getWeissLeaufer(int welcher){
        return weissLaeuferFiguren[welcher - 1];
    }

    /**
     * Get weiss turm weiss turm.
     *
     * @param welcher the welcher
     * @return the weiss turm
     */
    static WeissTurm getWeissTurm(int welcher){ return weissTurmFiguren[welcher - 1]; }

    /**
     * Get weiss pferd weiss pferd.
     *
     * @param welcher the welcher
     * @return the weiss pferd
     */
    static WeissPferd getWeissPferd(int welcher){
        return weissPferdFiguren[welcher - 1];
    }

    /**
     * Get weiss koenig weiss koenig.
     *
     * @return the weiss koenig
     */
    static WeissKoenig getWeissKoenig(){
        return weissKoenigFigur;
    }

    /**
     * Get weiss dame weiss dame.
     *
     * @return the weiss dame
     */
    static WeissDame getWeissDame(){
        return weissDameFigur;
    }

    /**
     * Get schwarz bauer schwarz bauer.
     *
     * @param welcher the welcher
     * @return the schwarz bauer
     */
    static SchwarzBauer getSchwarzBauer(int welcher){
        return schwarzBauerFiguren[welcher - 1];
    }

    /**
     * Get schwarz leaufer schwarz laeufer.
     *
     * @param welcher the welcher
     * @return the schwarz laeufer
     */
    static SchwarzLaeufer getSchwarzLeaufer(int welcher){
        return schwarzLaeuferFiguren[welcher - 1];
    }

    /**
     * Get schwarz turm schwarz turm.
     *
     * @param welcher the welcher
     * @return the schwarz turm
     */
    static SchwarzTurm getSchwarzTurm(int welcher){ return schwarzTurmFiguren[welcher - 1]; }

    /**
     * Get schwarz pferd schwarz pferd.
     *
     * @param welcher the welcher
     * @return the schwarz pferd
     */
    static SchwarzPferd getSchwarzPferd(int welcher){
        return schwarzPferdFiguren[welcher - 1];
    }

    /**
     * Get schwarz koenig schwarz koenig.
     *
     * @return the schwarz koenig
     */
    static SchwarzKoenig getSchwarzKoenig(){
        return schwarzKoenigFigur;
    }

    /**
     * Get schwarz dame schwarz dame.
     *
     * @return the schwarz dame
     */
    static SchwarzDame getSchwarzDame(){
        return schwarzDameFigur;
    }

    /**
     * Get pos int.
     *
     * @param wer the wer
     * @return the int
     */
    public static int getPos(String wer){
        switch (wer.charAt(0)){
            case 'w':
                switch (wer.charAt(1)){
                    case 'K':
                        return 0;
                    case 'D':
                        return 1;
                    case 'T':
                        switch (wer.charAt(2)){
                            case '1': return 2;
                            case '2': return 3;
                        }
                    case 'P':
                        switch (wer.charAt(2)){
                            case '1': return 4;
                            case '2': return 5;
                        }
                    case 'L':
                        switch (wer.charAt(2)){
                            case '1': return 6;
                            case '2': return 7;
                        }
                    case 'B':
                        switch (wer.charAt(2)){
                            case '1': return 8;
                            case '2': return 9;
                            case '3': return 10;
                            case '4': return 11;
                            case '5': return 12;
                            case '6': return 13;
                            case '7': return 14;
                            case '8': return 15;
                        }
                }
            case 's':
                switch (wer.charAt(1)){
                    case 'K':
                        return 16;
                    case 'D':
                        return 17;
                    case 'T':
                        switch (wer.charAt(2)){
                            case '1': return 18;
                            case '2': return 19;
                        }
                    case 'P':
                        switch (wer.charAt(2)){
                            case '1': return 20;
                            case '2': return 21;
                        }
                    case 'L':
                        switch (wer.charAt(2)){
                            case '1': return 22;
                            case '2': return 23;
                        }
                    case 'B':
                        switch (wer.charAt(2)){
                            case '1': return 24;
                            case '2': return 25;
                            case '3': return 26;
                            case '4': return 27;
                            case '5': return 28;
                            case '6': return 29;
                            case '7': return 30;
                            case '8': return 31;
                        }
                }
        }
        return 32;
    }
}