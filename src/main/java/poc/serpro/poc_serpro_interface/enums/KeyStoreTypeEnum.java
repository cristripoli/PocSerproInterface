package poc.serpro.poc_serpro_interface.enums;

import lombok.Getter;

public enum KeyStoreTypeEnum {
	  PKCS12("PKCS12"),
	  JKS("JKS");
	
	@Getter
	private String type;

	KeyStoreTypeEnum(String type) {
		this.type = type;
	}
}

