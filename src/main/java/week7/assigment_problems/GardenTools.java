package session7.assignment.p3;

public abstract class GardenTool {
    public abstract String use();
}

public class CuttingTool extends GardenTool {
    @Override
    public String use() {
        return "Using the tool in the garden, blade sharpened first";
    }
}

public class Pruner extends CuttingTool {
    @Override
    public String use() {
        return super.use() + ", then trimming branches precisely";
    }
}