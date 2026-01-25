package org.example;

public class Employee {

        private int id;

        private String name;

        private String Company;

        public Employee(){
            System.out.println("Employee object created");
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCompany(String company) {
            Company = company;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", Company='" + Company + '\'' +
                    '}';
        }
    }


