package com.example.app.domain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.dto.UserDTO;

@Mapper
public interface UserMapper {

	//XML
	public int insertXml(UserDTO userDto);
	public int updateXml(UserDTO userDto);
	public int deleteXml(String userid);
	
	public UserDTO selectAtXml(String userid);
	List<UserDTO> selectAllXml();
	List<Map<String,Object>> selectAllResultMapXml();
}
