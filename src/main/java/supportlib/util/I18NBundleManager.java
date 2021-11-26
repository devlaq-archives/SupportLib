package supportlib.util;

import supportlib.files.Fi;
import supportlib.struct.ObjectMap;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

public class I18NBundleManager {

    private Map<Locale, I18NBundle> bundles = new HashMap<>();

    /** Returns an empty bundle with no keys. */
    public I18NBundle createEmptyBundle(){
        I18NBundle bundle = I18NBundle.createEmptyBundle();
        return bundles.put(bundle.getLocale(), bundle);
    }

    /**
     * Creates a new bundle using the specified <code>baseFileHandle</code>, the default locale and the default encoding "UTF-8".
     * @param baseFileHandle the file handle to the base of the bundle
     * @return a bundle for the given base file handle and the default locale
     * @throws NullPointerException if <code>baseFileHandle</code> is <code>null</code>
     * @throws MissingResourceException if no bundle for the specified base file handle can be found
     */
    public I18NBundle createBundle(Fi baseFileHandle){
        I18NBundle bundle = I18NBundle.createBundle(baseFileHandle);
        return bundles.put(bundle.getLocale(), bundle);
    }

    /**
     * Creates a new bundle using the specified <code>baseFileHandle</code> and <code>locale</code>; the default encoding "UTF-8"
     * is used.
     * @param baseFileHandle the file handle to the base of the bundle
     * @param locale the locale for which a bundle is desired
     * @return a bundle for the given base file handle and locale
     * @throws NullPointerException if <code>baseFileHandle</code> or <code>locale</code> is <code>null</code>
     * @throws MissingResourceException if no bundle for the specified base file handle can be found
     */
    public I18NBundle createBundle(Fi baseFileHandle, Locale locale){
        I18NBundle bundle = I18NBundle.createBundle(baseFileHandle, locale);
        return bundles.put(bundle.getLocale(), bundle);
    }

    /**
     * Creates a new bundle using the specified <code>baseFileHandle</code> and <code>encoding</code>; the default locale is used.
     * @param baseFileHandle the file handle to the base of the bundle
     * @param encoding the charter encoding
     * @return a bundle for the given base file handle and locale
     * @throws NullPointerException if <code>baseFileHandle</code> or <code>encoding</code> is <code>null</code>
     * @throws MissingResourceException if no bundle for the specified base file handle can be found
     */
    public I18NBundle createBundle(Fi baseFileHandle, String encoding){
        I18NBundle bundle = I18NBundle.createBundle(baseFileHandle, encoding);
        return bundles.put(bundle.getLocale(), bundle);
    }

    /**
     * Creates a new bundle using the specified <code>baseFileHandle</code>, <code>locale</code> and <code>encoding</code>.
     * @param baseFileHandle the file handle to the base of the bundle
     * @param locale the locale for which a bundle is desired
     * @param encoding the charter encoding
     * @return a bundle for the given base file handle and locale
     * @throws NullPointerException if <code>baseFileHandle</code>, <code>locale</code> or <code>encoding</code> is
     * <code>null</code>
     * @throws MissingResourceException if no bundle for the specified base file handle can be found
     */
    public I18NBundle createBundle(Fi baseFileHandle, Locale locale, String encoding){
        I18NBundle bundle = I18NBundle.createBundle(baseFileHandle, locale, encoding);
        return bundles.put(bundle.getLocale(), bundle);
    }

    public final String get(Locale locale, String key) {
        return bundles.get(locale).get(key);
    }

    public String get(Locale locale, String key, String def) {
        return bundles.get(locale).get(def);
    }

    public String getOrNull(Locale locale, String key) {
        if(locale == null || key == null) return null;
        return getOrNull(locale, key);
    }

    public String getNotNull(Locale locale, String key) {
        return bundles.get(locale).getNotNull(key);
    }

    public boolean hasLocale(Locale locale) {
        return bundles.containsKey(locale);
    }

    public boolean has(String key) {
        for(I18NBundle bundle : bundles.values()) {
            if(bundle.has(key)) return true;
        }
        return false;
    }
}
