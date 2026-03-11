package top.likoslupus.ethaphio4j.api.save;

public interface SaveCodec<T> {

    T encode(SaveData data) throws Exception;

    SaveData decode(T encoded) throws Exception;

}
