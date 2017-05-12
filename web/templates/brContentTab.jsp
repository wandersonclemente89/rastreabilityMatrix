<table id="brTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${sprints}" var="sprint">
        <tr>
            <td>${sprint.id}</td>
            <td>${sprint.name}</td>
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
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#br-modal">
    <i class="glyphicon glyphicon glyphicon-plus"></i> Add Business Requirements
</button>

<!-- Modal -->
<div class="modal fade" id="br-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add Business Requirements</h4>
            </div>
            <div class="modal-body">
                <form method="post">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Name</label>
                        <input class="form-control" name="name" placeholder="Enter name">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Description</label>
                        <input class="form-control" name="description" placeholder="Enter description">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Customer needs</label>
                        <textarea class="form-control" name="customerNeeds" placeholder="Enter Customer needs"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Coments</label>
                        <textarea class="form-control" name="coments" placeholder="Enter coments"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="project">Members</label>
                        <select name="menbers" class="selectpicker form-control" multiple>
                            <option>Flávio</option>
                            <option>Wamderson</option>
                            
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