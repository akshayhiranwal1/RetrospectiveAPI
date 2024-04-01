package com.SIS.RetrospectiveService;

import com.SIS.RetrospectiveService.controller.RetrospectiveController;
import com.SIS.RetrospectiveService.mapper.IRetroMapper;
import com.SIS.RetrospectiveService.services.Retrospective.IRetroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RetrospectiveServiceApplicationTests {
	private RetrospectiveController _controller;
	private IRetroMapper _mapper;
	private IRetroService _service;

    @BeforeEach
	public void setUp()
	{
		_service = mock(IRetroService.class);
		_mapper = mock(IRetroMapper.class);
		_controller = new RetrospectiveController(_service);
	}

	@Test
	public void getAllRetrospective_ReturnsRetrospectiveList_AssertTrue() {
		var actual = TestData.retroList;
		var actualDto = _mapper.RetroEntityToDTO(actual);
		when(_service.getAll()).thenReturn(actualDto);
		var expected = _controller.getRetro().getBody();
		assertEquals(expected.stream().count(), actualDto.stream().count());
	}

	@Test
	public void getAllRetrospectiveByPaging_ReturnRetrospectiveList_AssertTrue() {
		var actual = TestData.retroList;
		var pagingResult = _mapper.RetroEntityToDTO(actual.stream().takeWhile(i->i.getId()<=3).collect(Collectors.toList()));
		when(_service.getAllByPaging(1,3)).thenReturn(
				pagingResult
		);
		var expected = _controller.getAllByPaging(1,3).getBody();
		assertEquals(expected,pagingResult);
	}

	@Test
	public void insertRetrospective_ReturnRetrospective_AssertTrue()
	{
		var actual = _mapper.RetroInputEntityToDTO(TestData.insertRetroModel);
		when(_service.saveRetro(actual)).thenReturn(TestData.insertRetroModel);

		var expected = _controller.saveRetro(actual).getBody();
		assertEquals(expected.getId(), 1);
	}
}
