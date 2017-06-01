<table id="trTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Comments</th>
            <th>BR#</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${technicalRequirements}" var="technicalRequirement">
        <tr>
            <td>${technicalRequirement.id}</td>
            <td>${technicalRequirement.name}</td>
            <td>${technicalRequirement.description}</td>
            <td>${technicalRequirement.comments}</td>
            <td>${technicalRequirement.brName}</td>
            <td>${technicalRequirement.statusName}</td>
            <td>

                <button type="button" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-pencil"/>
                </button>
                <a href="<c:url value="/tr/delete?id=${technicalRequirement.id}&buc_id=${BUC.id}"/>">
                   <button type="button" class="btn btn-danger" aria-label="Left Align">
                        <span class="glyphicon glyphicon glyphicon-trash"/>
                    </button>
                </a>
            </td>
        </tr>
    </c:forEach>
</tbody>
</table>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#tr-modal">
    <i class="glyphicon glyphicon glyphicon-plus"></i> Add Technical Requirement
</button>

<!-- Modal -->
<div class="modal fade" id="tr-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add Technical Requirement</h4>
            </div>
            <div class="modal-body">
                <form method="post" action="/rastreabilityMatrixICC/technicalRequirement/add">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Name</label>
                        <input class="form-control" name="name" placeholder="Enter name" required>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Description</label>
                        <input class="form-control" name="description" placeholder="Enter description" required>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Comments</label>
                        <textarea class="form-control" name="comments" placeholder="Enter comments"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="project">Business Requirement</label>
                        <select name="businessRequirements" class="selectpicker form-control" required>

                            <c:forEach items="${businessRequirements}" var="businessRequirement">
                                <option value="${businessRequirement.id}">${businessRequirement.name}</option>
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