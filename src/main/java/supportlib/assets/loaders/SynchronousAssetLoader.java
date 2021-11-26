package supportlib.assets.loaders;

import supportlib.assets.AssetLoaderParameters;
import supportlib.assets.AssetManager;
import supportlib.files.Fi;

public abstract class SynchronousAssetLoader<T, P extends AssetLoaderParameters<T>> extends AssetLoader<T, P>{
    public SynchronousAssetLoader(FileHandleResolver resolver){
        super(resolver);
    }

    public abstract T load(AssetManager assetManager, String fileName, Fi file, P parameter);
}
