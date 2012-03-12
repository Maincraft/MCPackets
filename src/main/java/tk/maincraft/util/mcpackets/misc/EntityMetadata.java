package tk.maincraft.util.mcpackets.misc;

public interface EntityMetadata<T> {
    T getValue();
    MetadataType getType();
}
