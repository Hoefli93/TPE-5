 
 
public class Pumpe implements Runnable {
 
        // Pumpleistung in Liter pro Sekunde
        private int performance;
        private Kühlkreislauf a;
        private int wasserGepumpt = 0;
        private int koeffizient;
        WärmetauscherFluss tauscherFl;
        WärmetauscherReaktor tauscherRe;
        Leitware lw;
 
        public Pumpe(int performance, Kühlkreislauf kreislauf, int koeffizient,WärmetauscherFluss TauscherFl,WärmetauscherReaktor tauscherRe,Leitware lw) {
                this.performance = performance;
                this.a = kreislauf;
                this.koeffizient = koeffizient;
                this.tauscherFl=tauscherFl;
                this.tauscherRe=tauscherRe;
                this.lw=lw;
        }
 
        @Override
        public void run() {
 
                while (!Thread.currentThread().isInterrupted()) {
 
                        synchronized (Leitware.LOCK) {
 
                                try {
                                       
                                        wasserGepumpt+=performance;
 
                                        if (wasserGepumpt >= 100) {
                                                a.rotieren();
                                                wärmeAustauschen();
                                                wasserGepumpt -= 100;
                                        }
                                        
                                        Leitware.LOCK.wait((long)(1000 / koeffizient));
                                } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                }
 
                        }
                }
 
        }
 
        public int getPerformance() {
                return this.performance;
        }
 
        public void setPerformance(int performance) {
                this.performance = performance;
        }
       
        private synchronized void wärmeAustauschen(){
                tauscherFl.wärmeTauschen();
                tauscherRe.wärmeTauschen();
                lw.printTemperatur();
        }
 
}