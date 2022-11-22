package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {
        public int TotalRecords;
        public int TotalPages;
        public int CurrentPage;

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            TotalRecords = totalRecords;
        }

        public int getTotalPages() {
            return TotalPages;
        }

        public void setTotalPages(int totalPages) {
            TotalPages = totalPages;
        }

        public int getCurrentPage() {
            return CurrentPage;
        }

        public void setCurrentPage(int currentPage) {
            CurrentPage = currentPage;
        }

}