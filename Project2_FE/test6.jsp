<table border="1">
    <tr>
      <td>제목</td>
      <td>
        <input type="text" name="title"/>
      </td>
    </tr>
    <tr>
      <td>내용</td>
      <td>
        <input type="text" name="content"/>
      </td>
    </tr>
  </table>


  @RequestMapping(value="addForm.do") // Mapping값을 ajax의 url과 일치시킨다.
  public String addFrom() {
    return "addForm"; // 미리 생성해 놓은 addForm.jsp 파일을 반환한다.
  }  