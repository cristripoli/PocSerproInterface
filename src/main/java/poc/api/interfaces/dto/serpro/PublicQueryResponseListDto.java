package poc.api.interfaces.dto.serpro;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import poc.api.interfaces.entities.serpro.PublicQueryResponse;

@Data
@AllArgsConstructor
public class PublicQueryResponseListDto {

	private List<PublicQueryResponse> list;
	
    public PublicQueryResponseListDto () {
    	list = new ArrayList<PublicQueryResponse>();
    }
}
