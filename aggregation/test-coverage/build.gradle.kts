plugins {
    id("com.zhaojj11.jam.report-aggregation")
    id("jacoco")
}

dependencies {
    aggregate("com.zhaojj11.jam.apps:sample")
}
