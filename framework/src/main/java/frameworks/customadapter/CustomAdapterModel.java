package frameworks.customadapter;

/**
 * Created by sandeepgoyal on 10/05/18.
 */

public abstract class CustomAdapterModel {
    abstract public String getText();
    @Override
    public boolean equals(Object obj) {
        return getText().equals(((CustomAdapterModel)obj).getText());
    }
}
