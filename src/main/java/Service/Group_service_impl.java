package Service;

import Entity.Settlement_Transcation;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Group_service_impl implements Group_Service{
    @Override
    public List<Settlement_Transcation> settleUp(int groupId) {
        return List.of();
    }
}
