package ExamMid.Exam_28_01;

public class Main {
    public static void main(String[] args) {

        // SQL queries for CRUD operations
        String insert1 = "insert into product(product_id, product_name, product_qty, product_brand) values(1, 'Ram', 2, 'Ocpc')";
        String insert2 = "insert into product(product_id, product_name, product_qty, product_brand) values(2, 'Keyboard', 1, 'A4tech')";
        String insert3 = "insert into product(product_id, product_name, product_qty, product_brand) values(3, 'Monitor', 5, 'Samsung')";

        String fetchData = "select * from product";
        String update = "update product set product_brand = 'Gigabyte' where product_id = 1";
        String delete = "delete from product where product_id = 3";

        CRUDOperation crudOperation = new CRUDOperation();

                        // here inserted Mode
//        crudOperation.insertProduct(insert1);
//        crudOperation.insertProduct(insert2);
//        crudOperation.insertProduct(insert3);
//

        crudOperation.fetchProduct(fetchData);
//        crudOperation.updateProduct(update);
//        crudOperation.deleteProduct(delete);
    }
}
