<table id="brTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Customer Needs</th>
            <th>Comments</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${businessRequirements}" var="businessRequirement">
        <tr>
            <td>${businessRequirement.id}</td>
            <td>${businessRequirement.name}</td>
            <td>${businessRequirement.description}</td>
            <td>${businessRequirement.customerNeeds}</td>
            <td>${businessRequirement.comments}</td>
            <td>${businessRequirement.statusId}</td>
            <td>
                <button type="button" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-pencil"/>
                </button>
                <a href="<c:url value="/team/delete?id=${businessRequirement.id}"/>">
                   <button type="button" class="btn btn-danger" aria-label="Left Align">
                        <span class="glyphicon glyphicon glyphicon-trash"/>
                    </button>
                </a>
            </td>
        </tr>
    </c:forEach>
</tbody>
</table>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#br-modal">
    <i class="glyphicon glyphicon glyphicon-plus"></i> Add Business Requirement
</button>
<!-- Modal -->
<div class="modal fade" id="br-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add Business Requirement</h4>
            </div>
            <div class="modal-body">
                <form method="post" action="/rastreabilityMatrixICC/businessRequirement/add">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Name</label>
                        <input class="form-control" name="name" placeholder="Enter name" required>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Description</label>
                        <input class="form-control" name="description" placeholder="Enter description" required>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Customer needs</label>
                        <textarea class="form-control" name="customerNeeds" placeholder="Enter Customer needs"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Comments</label>
                        <textarea class="form-control" name="comments" placeholder="Enter comments"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="project">Members</label>
                        <select name="members" class="selectpicker form-control" multiple>
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
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
       </div>
    </div>
</div>