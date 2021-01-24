import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LaptopModel implements Cloneable {
    private String modelId;
    private String processor;
    private String ram;
    private String hardDisk;
    private String RGB;

    @Override
    public Object clone() throws CloneNotSupportedException{
        return new LaptopModel(this.modelId,this.processor,this.ram,this.hardDisk,this.RGB);
    }
    @Override
    public String toString() {
        return String.format(this.modelId + " " + this.processor + " " + this.ram + " " + this.hardDisk + " " +this.RGB);
    }

}
