package com.kjcManager.json;

public class PaperTop {
    private Integer id;
    private String sort;
    private String corresAuthor;
    private String firstAuthor;
    private String paperTitle;
    private Integer citations;
    private Integer totalCitations;
    private String journalTitle;
    private String paperYear;
    private String year;
    private String addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? "" : sort.trim();
    }

    public String getCorresAuthor() {
        return corresAuthor;
    }

    public void setCorresAuthor(String corresAuthor) {
        this.corresAuthor = corresAuthor == null ? "" : corresAuthor.trim();
    }

    public String getFirstAuthor() {
        return firstAuthor;
    }

    public void setFirstAuthor(String firstAuthor) {
        this.firstAuthor = firstAuthor == null ? "" : firstAuthor.trim();
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle == null ? "" : paperTitle.trim();
    }

    public Integer getCitations() {
        return citations;
    }

    public void setCitations(Integer citations) {
        this.citations = citations;
    }

    public Integer getTotalCitations() {
        return totalCitations;
    }

    public void setTotalCitations(Integer totalCitations) {
        this.totalCitations = totalCitations;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle == null ? "" : journalTitle.trim();
    }

    public String getPaperYear() {
        return paperYear;
    }

    public void setPaperYear(String paperYear) {
        this.paperYear = paperYear == null ? "" : paperYear.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? "" : year.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? "" : addTime.trim();
    }

    @Override
    public String toString() {
        return "PaperTop{" +
                "id=" + id +
                ", sort='" + sort + '\'' +
                ", corresAuthor='" + corresAuthor + '\'' +
                ", firstAuthor='" + firstAuthor + '\'' +
                ", paperTitle='" + paperTitle + '\'' +
                ", citations=" + citations +
                ", totalCitations=" + totalCitations +
                ", journalTitle='" + journalTitle + '\'' +
                ", paperYear='" + paperYear + '\'' +
                ", year='" + year + '\'' +
                ", addTime='" + addTime + '\'' +
                '}';
    }
}
