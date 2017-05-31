<table id="tcTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Full Path</th>
            <th>Technical Requirement</th>
            <th>Team</th>
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
            <td>${testCase.tRName}</td>
            <td>${testCase.teamName}</td>
            <td>${testCase.testTypeName}</td>
            <td>${testCase.statusName}</td>
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
                <form method="post" action="/rastreabilityMatrixICC/testcase/add">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Name</label>
                        <input class="form-control" name="name" placeholder="Enter name" required>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Full Path</label>
                        <input class="form-control" name="fullPath" placeholder="Enter the full path of the test case" required>
                    </div>
                    <div class="form-group">
                        <label for="project">Team</label>
                        <select name="owner" class="selectpicker form-control" >
                            <c:forEach items="${teams}" var="team">
                                <option value="${team.id}">${team.name}</option>
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
                    <div class="form-group">
                        <label for="project">Technical Requirement</label>
                        <select name="technicalRequirement" class="selectpicker form-control" multiple required>
                            <c:forEach items="${technicalRequirements}" var="technicalRequirement">
                                <option value="${technicalRequirement.id}">${technicalRequirement.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                            <input value="${BUC.id}" type="hidden"  name="id"/>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
            
        </div>
    </div>
</div>