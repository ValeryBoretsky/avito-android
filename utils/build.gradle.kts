plugins {
    id("kotlin")
    id("java-test-fixtures")
    `maven-publish`
}

val kotlinVersion: String by project
val androidGradlePluginVersion: String by project
val antPatternMatcherVersion: String by project
val truthVersion: String by project
val mockitoKotlin2Version: String by project
val funktionaleVersion: String by project

dependencies {
    api("org.funktionale:funktionale-try:${funktionaleVersion}")
    implementation(gradleApi())
    implementation(project(":kotlin-dsl-support"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}")
    implementation("com.android.tools.build:gradle:$androidGradlePluginVersion")
    implementation("io.github.azagniotov:ant-style-path-matcher:$antPatternMatcherVersion")

    testImplementation("com.google.truth:truth:$truthVersion")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoKotlin2Version")
}

//todo withSourcesJar 6.0 gradle
val sourcesTask = tasks.create<Jar>("sourceJar") {
    classifier = "sources"
    from(sourceSets.main.get().allJava)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            artifact(sourcesTask)
        }
    }
}