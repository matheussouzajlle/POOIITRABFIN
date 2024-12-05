package Projetofinal.Biblioteca.dto;

import java.util.List;

public class RelatorioDTO {

    private List<String> labels;
    private List<Integer> values;

    // Getters e Setters
    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
