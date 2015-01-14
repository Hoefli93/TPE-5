 
 
public class Pumpe implements Runnable {
 
        // Pumpleistung in Liter pro Sekunde
        private int performance;
        private K�hlkreislauf a;
        private int wasserGepumpt = 0;
        private int koeffizient;
        W�rmetauscherFluss tauscherFl;
        W�rmetauscherReaktor tauscherRe;
        Leitware lw;
 
        public Pumpe(int performance, K�hlkreislauf kreislauf, int koeffizient,W�rmetauscherFluss TauscherFl,W�rmetauscherReaktor tauscherRe,Leitware lw) {
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
                                                w�rmeAustauschen();
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
       
        private synchronized void w�rmeAustauschen(){
                tauscherFl.w�rmeTauschen();
                tauscherRe.w�rmeTauschen();
                lw.printTemperatur();
        }
 
}