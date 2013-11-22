package katahistogram;

public abstract class HistogramViewer<T> {
    
    private Histogram<T> histrogram; 
    
    public HistogramViewer(Histogram<T> histrogram) {
        this.histrogram = histrogram;
    }
    
    public Histogram<T> getHistogram() {
        return histrogram;
    }
   
    public abstract void show();
    
   
}
