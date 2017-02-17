package br.com.testerd.model.enums;

public enum StatusReceitaDespesa {
	ATIVO(1), INATIVO(2);

	private int value;

	StatusReceitaDespesa(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static StatusReceitaDespesa parse(int id) {
		StatusReceitaDespesa status = null;
		for (StatusReceitaDespesa item : StatusReceitaDespesa.values()) {
			if (item.getValue() == id) {
				status = item;
				break;
			}
		}
		return status;
	}

};
