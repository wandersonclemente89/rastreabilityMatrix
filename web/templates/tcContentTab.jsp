<table id="tcTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>Id - wefwef</th>
            <th>Name</th>
            <th>Full Path</th>
            <th>Owner</th>
            <th>Test type</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${testCases}" var="testCase">
        <tr>
            <td>${testCase.id}</td>
            <td>${testCase.name}</td>
            <td>${testCase.fullPath}</td>
            <td>${testCase.employeesSignum}</td>
            <td>${testCase.testTypeId}</td>
            <td>

                <button type="button" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-pencil"/>
                </button>
                <a href="<c:url value="/team/delete?id=${sprint.id}"/>">
                   <button type="button" class="btn btn-danger" aria-label="Left Align">
                        <span class="glyphicon glyphicon glyphicon-trash"/>
                    </button>
                </a>
            </td>
        </tr>
    </c:forEach>
</tbody>
</table>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#tc-modal">
    <i class="glyphicon glyphicon glyphicon-plus"></i> Add Test Case
</button>

<!-- Modal -->
<div class="modal fade" id="tc-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add Test Case</h4>
            </div>
            <div class="modal-body">
                <form method="post">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Name</label>
                        <input class="form-control" name="name" placeholder="Enter name" required>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Full Path</label>
                        <input class="form-control" name="fullPath" placeholder="Enter the full path of the test case" required>
                    </div>
                    <div class="form-group">
                        <label for="project">Owner</label>
                        <select name="members" class="selectpicker form-control" >
                            <c:forEach items="${members}" var="member">
                                <option value="${member.signum}">${member.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="project">Status</label>
                        <select name="status" class="selectpicker form-control" >
                            <c:forEach items="${statuses}" var="status">
                                <option value="${status.id}">${status.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="project">Test Type</label>
                        <select name="testType" class="selectpicker form-control" >
                            <c:forEach items="${testTypes}" var="testType">
                                <option value="${testType.id}">${testType.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>