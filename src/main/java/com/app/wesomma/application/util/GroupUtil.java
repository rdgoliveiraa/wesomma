package com.app.wesomma.application.util;


import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.group.GroupDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupUtil {

    private GroupUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static GroupDTO parseFamilyToGroupDTO(Family family){
        return new GroupDTO(family, false);
    }

    public static List<GroupDTO> parseList(List<Family> families) {
        return families.stream().map(GroupDTO::new).collect(Collectors.toList());
    }

    public static List<Family> parseListToFamily(List<GroupDTO> groupsDTO) {
        List<Family> families = new ArrayList<>();
        for(GroupDTO group: groupsDTO) {
            Family family = new Family();
            families.add(family);
        }
        return families;
    }
}
