package com.onerivet.deskbook.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.onerivet.deskbook.models.payload.RequestHistoryDto;
import com.onerivet.deskbook.models.response.GenericResponse;
import com.onerivet.deskbook.services.RequestHistoryService;
import com.onerivet.deskbook.util.PaginationAndSorting;

class RequestHistoryControllerTest {


    @Mock
    private RequestHistoryService requestHistoryService;

    @InjectMocks
    private RequestHistoryController requestHistoryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getRequestHistory_withStatus_shouldReturnRequestHistory() {
        // Arrange
        Principal principal = mock(Principal.class);
        PaginationAndSorting pagination = mock(PaginationAndSorting.class);
        List<RequestHistoryDto> requestHistoryList = new ArrayList<>();
        requestHistoryList.add(new RequestHistoryDto());
        when(requestHistoryService.getRequestHistory(principal.getName(), pagination.createPageRequest(), 1))
                .thenReturn(requestHistoryList);

        // Act
        GenericResponse<List<RequestHistoryDto>> result =
                requestHistoryController.getRequestHistory(principal, pagination, 1);

        // Assert
        assertEquals(requestHistoryList, result.getData());
        assertEquals(null, result.getError());
        verify(requestHistoryService, times(1)).getRequestHistory(principal.getName(), pagination.createPageRequest(), 1);
    }

    @Test
    void getRequestHistory_withoutStatus_shouldReturnRequestHistory() {
        // Arrange
        Principal principal = mock(Principal.class);
        PaginationAndSorting pagination = mock(PaginationAndSorting.class);
        List<RequestHistoryDto> requestHistoryList = new ArrayList<>();
        requestHistoryList.add(new RequestHistoryDto());
        when(requestHistoryService.getRequestHistory(principal.getName(), pagination.createPageRequest(), null))
                .thenReturn(requestHistoryList);

        // Act
        GenericResponse<List<RequestHistoryDto>> result =
                requestHistoryController.getRequestHistory(principal, pagination, null);

        // Assert
        assertEquals(requestHistoryList, result.getData());
        assertEquals(null, result.getError());
        verify(requestHistoryService, times(1)).getRequestHistory(principal.getName(), pagination.createPageRequest(), null);
    }

    @Test
    void getRequestHistory_withName_shouldReturnRequestHistory() {
        // Arrange
        PaginationAndSorting paginationAndSorting = mock(PaginationAndSorting.class);
        List<RequestHistoryDto> requestHistoryList = new ArrayList<>();
        requestHistoryList.add(new RequestHistoryDto());
        when(requestHistoryService.searchByFirstNameOrLastName("John", paginationAndSorting.createPageRequest()))
                .thenReturn(requestHistoryList);

        // Act
        GenericResponse<List<RequestHistoryDto>> result =
                requestHistoryController.getRequestHistory("John", paginationAndSorting);

        // Assert
        assertEquals(requestHistoryList, result.getData());
        assertEquals(null, result.getError());
        verify(requestHistoryService, times(1)).searchByFirstNameOrLastName("John", paginationAndSorting.createPageRequest());
    }
    
    

}
