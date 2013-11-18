class WaterPouring{
    
    public static void main(String []args){
        int GoalVolume = 600;
        
        Cup A = new Cup("A", 900);
        Cup B = new Cup("B", 400);
        
        while (A.getCurrent() != GoalVolume) {
            if (A.isEmpty()) {
                A.fill();
            }
            System.out.println(A.toString());

            A.pour(B);
            if (B.isFilled()) {
                B.empty();
            }
        }
        System.out.println(A.toString());
        System.out.println("Water Pouring Completed.");
    }
}

class Cup {
    private String Name;
    private int Quantity;
    private int CurrentVolume;
    
    public Cup(String name, int quantity) {
        Name = name;
        Quantity = quantity;
    }
    
    public void fill() {
        CurrentVolume = Quantity;
    }
    
    public void empty() {
        CurrentVolume = 0;
    }
    
    public boolean isEmpty() {
        return CurrentVolume == 0;
    }
    
    public int getCurrent() {
        return CurrentVolume;
    }
    
    public boolean isFilled() {
        return CurrentVolume == Quantity;
    }
    
    public void pour(Cup target) {
        int targetVolumeToFill = target.Quantity - target.CurrentVolume;
        
        if (this.CurrentVolume > targetVolumeToFill) {
            target.fill();
            CurrentVolume -= targetVolumeToFill;
        }
        else {
            target.CurrentVolume += this.CurrentVolume;
            empty();
        }
    }
    
    @Override
    public String toString() {
        return "Cup " + Name + " has " + CurrentVolume;
    }
}
