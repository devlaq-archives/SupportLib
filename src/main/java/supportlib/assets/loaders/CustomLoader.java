package supportlib.assets.loaders;

import supportlib.*;
import supportlib.assets.*;
import supportlib.files.*;
import supportlib.struct.*;

public abstract class CustomLoader extends AsynchronousAssetLoader{
    public Runnable loaded = () -> {};

    public CustomLoader(){
        super(Core.files::internal);
    }

    @Override
    public Object loadSync(AssetManager manager, String fileName, Fi file, AssetLoaderParameters parameter){
        loaded.run();
        return this;
    }

    @Override
    public Seq<AssetDescriptor> getDependencies(String fileName, Fi file, AssetLoaderParameters parameter){
        return null;
    }
}
