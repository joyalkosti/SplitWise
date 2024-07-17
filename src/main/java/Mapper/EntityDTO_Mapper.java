package Mapper;

import DTOs.Group_DTO;
import DTOs.User_Friend_DTO;
import DTOs.User_Login_DTO;
import Entity.Group;
import Entity.User;

import java.util.ArrayList;
import java.util.List;

public class EntityDTO_Mapper {
    public static User_Login_DTO toDto(User user){
        User_Login_DTO logiDto=new User_Login_DTO();
        logiDto.setId(user.getId());
        logiDto.setName(user.getName());
        logiDto.setEmail(user.getEmail());

        //Conversion of user friends to friend list
        List<User_Friend_DTO> friendDtoList=new ArrayList<>();
        for(User friend: user.getFriends()){
            friendDtoList.add(toFriendDto(friend));
        }
        logiDto.setUserFriendList(friendDtoList);

        //Conversion of group to groupDto
        List<Group_DTO> groupDtos=new ArrayList<>();
        for(Group group: user.getGroupList()){
            groupDtos.add(toDTO(group));
        }
        logiDto.setGroupDtoList(groupDtos);

        return logiDto;

    }

    public static User_Friend_DTO toFriendDto(User user){
        User_Friend_DTO userFriendDto=new User_Friend_DTO();
        userFriendDto.setId(user.getId());
        userFriendDto.setFriendName(user.getName());
        return userFriendDto;
    }

    public static Group_DTO toDTO(Group group){
        return null;
    }
}
