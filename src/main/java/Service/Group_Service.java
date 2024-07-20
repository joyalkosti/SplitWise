package Service;

import Entity.Settlement_Transcation;

import java.util.List;

public interface Group_Service {
    List<Settlement_Transcation> settleUp(int groupId);

}
