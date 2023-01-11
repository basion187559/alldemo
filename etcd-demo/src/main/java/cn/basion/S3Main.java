package cn.basion;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2023/1/11
 */
public class S3Main {

    public static void main(String[] args) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        // Create a minioClient with the MinIO server playground, its access key and secret key.
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("http://10.0.0.10:31084")
                        .credentials("workbench", "workbench123")
                        .build();

        // Make 'asiatrip' bucket if not exist.
        boolean found =
                minioClient.bucketExists(BucketExistsArgs.builder().bucket("asiatrip").build());
        if (!found) {
            // Make a new bucket called 'asiatrip'.
            minioClient.makeBucket(MakeBucketArgs.builder().bucket("asiatrip").build());
        } else {
            System.out.println("Bucket 'asiatrip' already exists.");
        }
    }
}
