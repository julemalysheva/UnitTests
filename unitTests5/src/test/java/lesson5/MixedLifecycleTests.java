//package lesson5;
//
//@Testcontainers
//class MixedLifecycleTests {
//    @Container
//    private PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer()
//            .withDatabaseName("foo")
//            .withUsername("foo")
//            .withPassword("secret");
//    @Test
//    void test() {
//        assertThat(postgresqlContainer.isRunning()).isTrue();
//    }
//}