package ru.airconcept.model;

public class ModelMaterials {
    private int material_id;
    private String name_ru;

    public ModelMaterials(int material_id, String name_ru) {
        this.material_id = material_id;
        this.name_ru = name_ru;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public String getName_ru() {
        return name_ru;
    }

    public void setName_ru(String name_ru) {
        this.name_ru = name_ru;
    }

    @Override
    public String toString() {
        return "ModelMaterials{" +
                "material_id=" + material_id +
                ", name_ru='" + name_ru + '\'' +
                '}';
    }
}
