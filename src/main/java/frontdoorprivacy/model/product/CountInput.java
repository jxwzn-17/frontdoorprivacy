package frontdoorprivacy.model.product;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CountInput {
    int id;
    int count;

    public CountInput() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
